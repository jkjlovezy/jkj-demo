package com.study.hessian;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import com.caucho.hessian.io.Hessian2Input;
import com.caucho.hessian.io.SerializerFactory;

public class Hessian2Deseiralizer {
    public static Hessian2Deseiralizer INSTANCE = new Hessian2Deseiralizer();

    public <T> T deserialize(byte[] bytes, Class<T> typeClass) throws IOException {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        Hessian2Input hi = new Hessian2Input(bis);
        SerializerFactory serializerFactory = new SerializerFactory();
        serializerFactory.setAllowNonSerializable(true);
        hi.setSerializerFactory(serializerFactory);
        return (T) hi.readObject(typeClass);
    }
}
