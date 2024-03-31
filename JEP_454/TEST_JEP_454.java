//Foreign Function & Memory API – JEP 454

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_LONG;

void main() throws Throwable {
    Linker linker = Linker.nativeLinker();
    SymbolLookup stdlib = linker.defaultLookup();
    MethodHandle strlen = linker.downcallHandle(
            stdlib.find("strlen").orElseThrow(),
            FunctionDescriptor.of(JAVA_LONG, ADDRESS));
    try (Arena offHeap = Arena.ofConfined()) {
        MemorySegment str = offHeap.allocateFrom("Ajincodew !");
        long len = (long) strlen.invoke(str);
        System.out.println(STR."len = \{len}");
    }
}
