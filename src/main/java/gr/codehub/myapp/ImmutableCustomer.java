package gr.codehub.myapp;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public final class ImmutableCustomer {

    private final int code;
    private final String name;
    private final boolean isActive;
    private final double balance;


}
