/*
 * Copyright 2016-2023 DiffPlug
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.diffplug.spotless.extra.groovy;

import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import com.diffplug.spotless.TestProvisioner;
import com.diffplug.spotless.extra.eclipse.EquoResourceHarness;

class GrEclipseFormatterStepTest extends EquoResourceHarness {
	private final static String INPUT = "class F{ def m(){} }";
	private final static String EXPECTED = "class F{\n\tdef m(){}\n}";

	public GrEclipseFormatterStepTest() {
		super(GrEclipseFormatterStep.createBuilder(TestProvisioner.mavenCentral()), INPUT, EXPECTED);
	}

	@ParameterizedTest
	@MethodSource
	void formatWithVersion(String version) throws Exception {
		assertFormatted(version);
	}

	private static Stream<String> formatWithVersion() {
		return Stream.of("4.25", GrEclipseFormatterStep.defaultVersion());
	}
}
