package com.snav.grpc;

import com.snav.grpc.stub.SampleTestGrpc;
import com.snav.grpc.stub.Sampletest;
import io.grpc.Channel;
import io.grpc.ManagedChannelBuilder;

public class GrpcClientClass {
		public static void main(String[] args) {
				ManagedChannelBuilder<?> channelBuilder = ManagedChannelBuilder.forAddress("localhost", 4444).usePlaintext();

				Channel channel = channelBuilder.build();

				SampleTestGrpc.SampleTestBlockingStub blockingStub = SampleTestGrpc.newBlockingStub(channel);

				Sampletest.SampleTestRequestDTO request = Sampletest.SampleTestRequestDTO.newBuilder().setId(12)
						.build();

				Sampletest.SampleTestResponseDTO response = blockingStub.read(request);

				System.out.println("Response name : "+ response.getName() +", desc : "+response.getDescription()+", id : "+response.getId());


		}
}
