package com.drive.drive_manager;

import org.springframework.boot.SpringApplication;

public class TestDriveManagerApplication {

	public static void main(String[] args) {
		SpringApplication.from(DriveManagerApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
