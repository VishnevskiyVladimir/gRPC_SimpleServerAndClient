import com.example.grpc.GreetingServiceOuterClass;
import io.grpc.stub.StreamObserver;

public class GreetingServiceImplementation extends com.example.grpc.GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GreetingServiceOuterClass.HelloRequest request,
                         StreamObserver<GreetingServiceOuterClass.HelloResponse> responseObserver) {
        System.out.println(request);
        GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse.newBuilder()
                .setFirstname(request.getFirstname())
                .setLastname(request.getLastname())
                .setAge(22)
                .setMood(GreetingServiceOuterClass.Mood.HAPPY)
                .addHobbies("Drinking")
                .addHobbies("Swimming")
                .putSomeMap("key1", "val1")
                .putSomeMap("key2", "val2")
                .build();

        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
