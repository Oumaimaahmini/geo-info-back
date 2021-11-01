package com.geoInfo.project.controller;

import com.geoInfo.project.dao.IntermediaireRepository;
import com.geoInfo.project.dao.UserRepository;
import com.geoInfo.project.model.AuthenticationRequest;
import com.geoInfo.project.model.Intermediaire;
import com.geoInfo.project.service.MyUserDetailsService;
import com.geoInfo.project.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class IntermediaireController {

	@Autowired
	private IntermediaireRepository intermediaireRepository;

	@Autowired
	private AuthenticationManager authenticationManager;

	@Autowired
	private JwtUtil jwtTokenUtil;

	@Autowired
	UserRepository userRepsitory ;

	@Autowired
	private MyUserDetailsService userDetailsService;

    // all inters
	@RequestMapping(method= RequestMethod.GET, value="/intermediaires")
	public List<Intermediaire> getIntermediaires() {
		return intermediaireRepository.findAll();
	}

	// inter by id
	@RequestMapping(method= RequestMethod.GET, value= "/intermediaires/{id}")
	public Intermediaire getIntermediaireById(@PathVariable Long id){
		return intermediaireRepository.findById(id).get();
	}

   // delete inter
	@RequestMapping(method= RequestMethod.DELETE,value="/intermediaires/{id}")
	public void deleteIntermediaire(@PathVariable Long id) {
		intermediaireRepository.deleteById(id);
	}

	// add inter

	@RequestMapping(method= RequestMethod.POST,value="/intermediaires")
	public Intermediaire saveIntermediaire(Intermediaire intermediaire) {
		Intermediaire savedIntermediaire = intermediaireRepository.save(intermediaire);
		return savedIntermediaire;
	}

	// update inter

	@RequestMapping(method=RequestMethod.PUT,value="/intermediaires/{id}")
	public Intermediaire updateCategory(@RequestBody Intermediaire e , @PathVariable Long id ) {
		return intermediaireRepository.findById(id)
				.map(intermediaire -> {
					intermediaire.setFirstName(e.getFirstName());
					intermediaire.setLastName(e.getLastName());
					intermediaire.setEmail(e.getEmail());
					intermediaire.setPassword(e.getPassword());
					intermediaire.setAdresse(e.getAdresse());
					return intermediaireRepository.save(intermediaire);
				})
				.orElseGet(() -> {
					e.setId(id);
					return intermediaireRepository.save(e);
				});
	}

	// jwt creation

	@RequestMapping(value = "/authenticate", method = RequestMethod.POST)
	public /* ResponseEntity<?> */ String createAuthenticationToken(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
		System.out.println("authenticate called");
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}


		final UserDetails userDetails = userDetailsService
				.loadUserByUsername(authenticationRequest.getUsername());

		final String jwt = jwtTokenUtil.generateToken(userDetails);
		return jwt ;

		// return ResponseEntity.ok(new AuthenticationResponse(jwt));


	}



}


