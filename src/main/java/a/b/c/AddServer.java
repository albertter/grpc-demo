package a.b.c;

import io.grpc.ServerBuilder;
import io.grpc.stub.StreamObserver;


/**
 * @author albert
 * @date 2021/8/31 031
 */
public class AddServer extends AddServiceGrpc.AddServiceImplBase {
    public static void main(String[] args) throws Exception {
        ServerBuilder.forPort(9999).addService(new AddServer()).build().start();
        System.out.println("server start at 9999");
        while (true) {

        }
    }

    public void add(AddRequest request, StreamObserver<AddResponse> responseObserver) {
        int res = myAdd(request.getA(), request.getB());
        responseObserver.onNext(AddResponse.newBuilder().setRes(res).build());
        responseObserver.onCompleted();
    }

    private int myAdd(int a, int b) {
        return a + b;
    }
}
