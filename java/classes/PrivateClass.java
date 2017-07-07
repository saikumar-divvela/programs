public class PrivateClass {
    public static void main(String args[]) throws Exception {
        System.out.println("In main");
    }
}

private class TestPrivateClass { // compilation error
}

protected class TestProtectedClass { // compilation error
}

class TestDefaultClass {
}
