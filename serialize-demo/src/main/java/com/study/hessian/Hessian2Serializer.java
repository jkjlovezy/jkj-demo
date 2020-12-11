package com.study.hessian;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import com.caucho.hessian.io.Hessian2Output;
import com.caucho.hessian.io.SerializerFactory;

public class Hessian2Serializer {
    public static Hessian2Serializer INSTANCE = new Hessian2Serializer();

    public byte[] serialize(Object object) throws IOException {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        Hessian2Output ho = new Hessian2Output(bos);
        SerializerFactory serializerFactory = new SerializerFactory();
        serializerFactory.setAllowNonSerializable(true);
        ho.setSerializerFactory(serializerFactory);
        ho.writeObject(object);
        ho.flush();
        return bos.toByteArray();
    }
}
