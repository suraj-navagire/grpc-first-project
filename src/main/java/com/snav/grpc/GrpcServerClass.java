package com.snav.grpc;

import com.snav.grpc.service.SampleTestService;
import io.grpc.Server;
import io.grpc.ServerBuilder;

import java.io.IOException;

public class GrpcServerClass {
		public static void main(String[] args) throws IOException, InterruptedException {
				try {
						Server server = ServerBuilder.forPort(4444).addService(new SampleTestService()).build();

						server.start();

						System.out.println("Finlimit Application started");
						server.awaitTermination();
				} catch (Throwable e){
						e.printStackTrace();
				}

		}
}
