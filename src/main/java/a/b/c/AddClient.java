package a.b.c;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;

/**
 * @author albert
 * @date 2021/8/31 031
 */
public class AddClient {
    ManagedChannel managedChannel;
    AddServiceGrpc.AddServiceBlockingStub stub;


    public AddClient() {
        managedChannel = ManagedChannelBuilder.forAddress("127.0.0.1", 9999).usePlaintext().build();
        stub = AddServiceGrpc.newBlockingStub(managedChannel);
    }

    public static void main(String[] args) {

        int a = 200, b = 300;
        AddClient addClient = new AddClient();
        AddResponse addResponse = addClient.stub.add(AddRequest.newBuilder().setA(a).setB(b).build());
        System.out.println(addResponse.getRes());
    }
}
