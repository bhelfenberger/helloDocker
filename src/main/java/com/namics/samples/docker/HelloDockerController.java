/*
 * Copyright 2000-2016 Namics AG. All rights reserved.
 */

package com.namics.samples.docker;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * HelloDockerController.
 *
 * @author aschaefer, Namics AG
 * @since 13.06.16 09:58
 */
@RestController
public class HelloDockerController {
	@RequestMapping
	public String hello() {
		return "Hello Docker";
	}
}
