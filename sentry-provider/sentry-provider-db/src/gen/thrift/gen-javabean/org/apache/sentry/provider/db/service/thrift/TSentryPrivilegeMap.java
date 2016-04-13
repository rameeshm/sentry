/**
 * Autogenerated by Thrift Compiler (0.9.0)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.sentry.provider.db.service.thrift;

import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.EnumMap;
import java.util.Set;
import java.util.HashSet;
import java.util.EnumSet;
import java.util.Collections;
import java.util.BitSet;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TSentryPrivilegeMap implements org.apache.thrift.TBase<TSentryPrivilegeMap, TSentryPrivilegeMap._Fields>, java.io.Serializable, Cloneable {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TSentryPrivilegeMap");

  private static final org.apache.thrift.protocol.TField PRIVILEGE_MAP_FIELD_DESC = new org.apache.thrift.protocol.TField("privilegeMap", org.apache.thrift.protocol.TType.MAP, (short)1);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TSentryPrivilegeMapStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TSentryPrivilegeMapTupleSchemeFactory());
  }

  private Map<String,Set<TSentryPrivilege>> privilegeMap; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PRIVILEGE_MAP((short)1, "privilegeMap");

    private static final Map<String, _Fields> byName = new HashMap<String, _Fields>();

    static {
      for (_Fields field : EnumSet.allOf(_Fields.class)) {
        byName.put(field.getFieldName(), field);
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, or null if its not found.
     */
    public static _Fields findByThriftId(int fieldId) {
      switch(fieldId) {
        case 1: // PRIVILEGE_MAP
          return PRIVILEGE_MAP;
        default:
          return null;
      }
    }

    /**
     * Find the _Fields constant that matches fieldId, throwing an exception
     * if it is not found.
     */
    public static _Fields findByThriftIdOrThrow(int fieldId) {
      _Fields fields = findByThriftId(fieldId);
      if (fields == null) throw new IllegalArgumentException("Field " + fieldId + " doesn't exist!");
      return fields;
    }

    /**
     * Find the _Fields constant that matches name, or null if its not found.
     */
    public static _Fields findByName(String name) {
      return byName.get(name);
    }

    private final short _thriftId;
    private final String _fieldName;

    _Fields(short thriftId, String fieldName) {
      _thriftId = thriftId;
      _fieldName = fieldName;
    }

    public short getThriftFieldId() {
      return _thriftId;
    }

    public String getFieldName() {
      return _fieldName;
    }
  }

  // isset id assignments
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PRIVILEGE_MAP, new org.apache.thrift.meta_data.FieldMetaData("privilegeMap", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.MapMetaData(org.apache.thrift.protocol.TType.MAP, 
            new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING), 
            new org.apache.thrift.meta_data.SetMetaData(org.apache.thrift.protocol.TType.SET, 
                new org.apache.thrift.meta_data.StructMetaData(org.apache.thrift.protocol.TType.STRUCT, TSentryPrivilege.class)))));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TSentryPrivilegeMap.class, metaDataMap);
  }

  public TSentryPrivilegeMap() {
  }

  public TSentryPrivilegeMap(
    Map<String,Set<TSentryPrivilege>> privilegeMap)
  {
    this();
    this.privilegeMap = privilegeMap;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TSentryPrivilegeMap(TSentryPrivilegeMap other) {
    if (other.isSetPrivilegeMap()) {
      Map<String,Set<TSentryPrivilege>> __this__privilegeMap = new HashMap<String,Set<TSentryPrivilege>>();
      for (Map.Entry<String, Set<TSentryPrivilege>> other_element : other.privilegeMap.entrySet()) {

        String other_element_key = other_element.getKey();
        Set<TSentryPrivilege> other_element_value = other_element.getValue();

        String __this__privilegeMap_copy_key = other_element_key;

        Set<TSentryPrivilege> __this__privilegeMap_copy_value = new HashSet<TSentryPrivilege>();
        for (TSentryPrivilege other_element_value_element : other_element_value) {
          __this__privilegeMap_copy_value.add(new TSentryPrivilege(other_element_value_element));
        }

        __this__privilegeMap.put(__this__privilegeMap_copy_key, __this__privilegeMap_copy_value);
      }
      this.privilegeMap = __this__privilegeMap;
    }
  }

  public TSentryPrivilegeMap deepCopy() {
    return new TSentryPrivilegeMap(this);
  }

  @Override
  public void clear() {
    this.privilegeMap = null;
  }

  public int getPrivilegeMapSize() {
    return (this.privilegeMap == null) ? 0 : this.privilegeMap.size();
  }

  public void putToPrivilegeMap(String key, Set<TSentryPrivilege> val) {
    if (this.privilegeMap == null) {
      this.privilegeMap = new HashMap<String,Set<TSentryPrivilege>>();
    }
    this.privilegeMap.put(key, val);
  }

  public Map<String,Set<TSentryPrivilege>> getPrivilegeMap() {
    return this.privilegeMap;
  }

  public void setPrivilegeMap(Map<String,Set<TSentryPrivilege>> privilegeMap) {
    this.privilegeMap = privilegeMap;
  }

  public void unsetPrivilegeMap() {
    this.privilegeMap = null;
  }

  /** Returns true if field privilegeMap is set (has been assigned a value) and false otherwise */
  public boolean isSetPrivilegeMap() {
    return this.privilegeMap != null;
  }

  public void setPrivilegeMapIsSet(boolean value) {
    if (!value) {
      this.privilegeMap = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PRIVILEGE_MAP:
      if (value == null) {
        unsetPrivilegeMap();
      } else {
        setPrivilegeMap((Map<String,Set<TSentryPrivilege>>)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PRIVILEGE_MAP:
      return getPrivilegeMap();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PRIVILEGE_MAP:
      return isSetPrivilegeMap();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TSentryPrivilegeMap)
      return this.equals((TSentryPrivilegeMap)that);
    return false;
  }

  public boolean equals(TSentryPrivilegeMap that) {
    if (that == null)
      return false;

    boolean this_present_privilegeMap = true && this.isSetPrivilegeMap();
    boolean that_present_privilegeMap = true && that.isSetPrivilegeMap();
    if (this_present_privilegeMap || that_present_privilegeMap) {
      if (!(this_present_privilegeMap && that_present_privilegeMap))
        return false;
      if (!this.privilegeMap.equals(that.privilegeMap))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    HashCodeBuilder builder = new HashCodeBuilder();

    boolean present_privilegeMap = true && (isSetPrivilegeMap());
    builder.append(present_privilegeMap);
    if (present_privilegeMap)
      builder.append(privilegeMap);

    return builder.toHashCode();
  }

  public int compareTo(TSentryPrivilegeMap other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;
    TSentryPrivilegeMap typedOther = (TSentryPrivilegeMap)other;

    lastComparison = Boolean.valueOf(isSetPrivilegeMap()).compareTo(typedOther.isSetPrivilegeMap());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetPrivilegeMap()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.privilegeMap, typedOther.privilegeMap);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    return 0;
  }

  public _Fields fieldForId(int fieldId) {
    return _Fields.findByThriftId(fieldId);
  }

  public void read(org.apache.thrift.protocol.TProtocol iprot) throws org.apache.thrift.TException {
    schemes.get(iprot.getScheme()).getScheme().read(iprot, this);
  }

  public void write(org.apache.thrift.protocol.TProtocol oprot) throws org.apache.thrift.TException {
    schemes.get(oprot.getScheme()).getScheme().write(oprot, this);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder("TSentryPrivilegeMap(");
    boolean first = true;

    sb.append("privilegeMap:");
    if (this.privilegeMap == null) {
      sb.append("null");
    } else {
      sb.append(this.privilegeMap);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetPrivilegeMap()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'privilegeMap' is unset! Struct:" + toString());
    }

    // check for sub-struct validity
  }

  private void writeObject(java.io.ObjectOutputStream out) throws java.io.IOException {
    try {
      write(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(out)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private void readObject(java.io.ObjectInputStream in) throws java.io.IOException, ClassNotFoundException {
    try {
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TSentryPrivilegeMapStandardSchemeFactory implements SchemeFactory {
    public TSentryPrivilegeMapStandardScheme getScheme() {
      return new TSentryPrivilegeMapStandardScheme();
    }
  }

  private static class TSentryPrivilegeMapStandardScheme extends StandardScheme<TSentryPrivilegeMap> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TSentryPrivilegeMap struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PRIVILEGE_MAP
            if (schemeField.type == org.apache.thrift.protocol.TType.MAP) {
              {
                org.apache.thrift.protocol.TMap _map112 = iprot.readMapBegin();
                struct.privilegeMap = new HashMap<String,Set<TSentryPrivilege>>(2*_map112.size);
                for (int _i113 = 0; _i113 < _map112.size; ++_i113)
                {
                  String _key114; // required
                  Set<TSentryPrivilege> _val115; // required
                  _key114 = iprot.readString();
                  {
                    org.apache.thrift.protocol.TSet _set116 = iprot.readSetBegin();
                    _val115 = new HashSet<TSentryPrivilege>(2*_set116.size);
                    for (int _i117 = 0; _i117 < _set116.size; ++_i117)
                    {
                      TSentryPrivilege _elem118; // required
                      _elem118 = new TSentryPrivilege();
                      _elem118.read(iprot);
                      _val115.add(_elem118);
                    }
                    iprot.readSetEnd();
                  }
                  struct.privilegeMap.put(_key114, _val115);
                }
                iprot.readMapEnd();
              }
              struct.setPrivilegeMapIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          default:
            org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
        }
        iprot.readFieldEnd();
      }
      iprot.readStructEnd();
      struct.validate();
    }

    public void write(org.apache.thrift.protocol.TProtocol oprot, TSentryPrivilegeMap struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      if (struct.privilegeMap != null) {
        oprot.writeFieldBegin(PRIVILEGE_MAP_FIELD_DESC);
        {
          oprot.writeMapBegin(new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.SET, struct.privilegeMap.size()));
          for (Map.Entry<String, Set<TSentryPrivilege>> _iter119 : struct.privilegeMap.entrySet())
          {
            oprot.writeString(_iter119.getKey());
            {
              oprot.writeSetBegin(new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, _iter119.getValue().size()));
              for (TSentryPrivilege _iter120 : _iter119.getValue())
              {
                _iter120.write(oprot);
              }
              oprot.writeSetEnd();
            }
          }
          oprot.writeMapEnd();
        }
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TSentryPrivilegeMapTupleSchemeFactory implements SchemeFactory {
    public TSentryPrivilegeMapTupleScheme getScheme() {
      return new TSentryPrivilegeMapTupleScheme();
    }
  }

  private static class TSentryPrivilegeMapTupleScheme extends TupleScheme<TSentryPrivilegeMap> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TSentryPrivilegeMap struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      {
        oprot.writeI32(struct.privilegeMap.size());
        for (Map.Entry<String, Set<TSentryPrivilege>> _iter121 : struct.privilegeMap.entrySet())
        {
          oprot.writeString(_iter121.getKey());
          {
            oprot.writeI32(_iter121.getValue().size());
            for (TSentryPrivilege _iter122 : _iter121.getValue())
            {
              _iter122.write(oprot);
            }
          }
        }
      }
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TSentryPrivilegeMap struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      {
        org.apache.thrift.protocol.TMap _map123 = new org.apache.thrift.protocol.TMap(org.apache.thrift.protocol.TType.STRING, org.apache.thrift.protocol.TType.SET, iprot.readI32());
        struct.privilegeMap = new HashMap<String,Set<TSentryPrivilege>>(2*_map123.size);
        for (int _i124 = 0; _i124 < _map123.size; ++_i124)
        {
          String _key125; // required
          Set<TSentryPrivilege> _val126; // required
          _key125 = iprot.readString();
          {
            org.apache.thrift.protocol.TSet _set127 = new org.apache.thrift.protocol.TSet(org.apache.thrift.protocol.TType.STRUCT, iprot.readI32());
            _val126 = new HashSet<TSentryPrivilege>(2*_set127.size);
            for (int _i128 = 0; _i128 < _set127.size; ++_i128)
            {
              TSentryPrivilege _elem129; // required
              _elem129 = new TSentryPrivilege();
              _elem129.read(iprot);
              _val126.add(_elem129);
            }
          }
          struct.privilegeMap.put(_key125, _val126);
        }
      }
      struct.setPrivilegeMapIsSet(true);
    }
  }

}

