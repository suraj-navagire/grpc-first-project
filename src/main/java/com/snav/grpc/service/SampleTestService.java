package com.snav.grpc.service;

import com.snav.grpc.stub.SampleTestGrpc;
import com.snav.grpc.stub.Sampletest;
import io.grpc.stub.StreamObserver;

public class SampleTestService  extends SampleTestGrpc.SampleTestImplBase {

		@Override public void read(Sampletest.SampleTestRequestDTO request,
				StreamObserver<Sampletest.SampleTestResponseDTO> responseObserver) {
				System.out.println("Inside read method");

				int id = request.getId();

				System.out.println("Reading id : "+ id);

				Sampletest.SampleTestResponseDTO response = fetchAndBuildReponse(id);

				responseObserver.onNext(response);

				responseObserver.onCompleted();

				System.out.println("Returning response");
		}

		private Sampletest.SampleTestResponseDTO fetchAndBuildReponse(int id){
				Sampletest.SampleTestResponseDTO.Builder builder = Sampletest.SampleTestResponseDTO.newBuilder();

				builder.setId(id);
				builder.setDescription("First limit package");
				builder.setName("Finlimit-package-1");

				return builder.build();
		}
}
