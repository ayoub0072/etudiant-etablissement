package com.dev.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.dev.service.EtablissementService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class EtablissementController {

	@Autowired
	EtablissementService etablissementService;
	
	
}
