package net.loveruby.cflat.entity;
import net.loveruby.cflat.type.TypeRef;
import net.loveruby.cflat.type.ParamTypeRefs;
import net.loveruby.cflat.ast.Location;
import java.util.List;
import java.util.ArrayList;

public class Params extends ParamSlots<Param>
        implements net.loveruby.cflat.ast.Dumpable {
    public Params(Location loc, List<Param> paramDescs) {
        super(loc, paramDescs, false);
    }

    public List<Param> parameters() {
        return paramDescriptors;
    }

    public ParamTypeRefs parametersTypeRef() {
        List<TypeRef> typerefs = new ArrayList<TypeRef>();
        for (Param param : paramDescriptors) {
            typerefs.add(param.typeNode().typeRef());
        }
        return new ParamTypeRefs(location, typerefs, vararg);
    }

    public boolean equals(Object other) {
        return (other instanceof Params) && equals((Params)other);
    }

    public boolean equals(Params other) {
        return other.vararg == vararg
                && other.paramDescriptors.equals(paramDescriptors);
    }
    
    public void dump(net.loveruby.cflat.ast.Dumper d) {
        d.printNodeList("parameters", parameters());
    }
}
