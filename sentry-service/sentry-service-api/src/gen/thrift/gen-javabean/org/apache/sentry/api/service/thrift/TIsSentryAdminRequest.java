/**
 * Autogenerated by Thrift Compiler (0.9.3)
 *
 * DO NOT EDIT UNLESS YOU ARE SURE THAT YOU KNOW WHAT YOU ARE DOING
 *  @generated
 */
package org.apache.sentry.api.service.thrift;

import org.apache.thrift.scheme.IScheme;
import org.apache.thrift.scheme.SchemeFactory;
import org.apache.thrift.scheme.StandardScheme;

import org.apache.thrift.scheme.TupleScheme;
import org.apache.thrift.protocol.TTupleProtocol;
import org.apache.thrift.protocol.TProtocolException;
import org.apache.thrift.EncodingUtils;
import org.apache.thrift.TException;
import org.apache.thrift.async.AsyncMethodCallback;
import org.apache.thrift.server.AbstractNonblockingServer.*;
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
import javax.annotation.Generated;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SuppressWarnings({"cast", "rawtypes", "serial", "unchecked"})
@Generated(value = "Autogenerated by Thrift Compiler (0.9.3)")
public class TIsSentryAdminRequest implements org.apache.thrift.TBase<TIsSentryAdminRequest, TIsSentryAdminRequest._Fields>, java.io.Serializable, Cloneable, Comparable<TIsSentryAdminRequest> {
  private static final org.apache.thrift.protocol.TStruct STRUCT_DESC = new org.apache.thrift.protocol.TStruct("TIsSentryAdminRequest");

  private static final org.apache.thrift.protocol.TField PROTOCOL_VERSION_FIELD_DESC = new org.apache.thrift.protocol.TField("protocol_version", org.apache.thrift.protocol.TType.I32, (short)1);
  private static final org.apache.thrift.protocol.TField USER_NAME_FIELD_DESC = new org.apache.thrift.protocol.TField("userName", org.apache.thrift.protocol.TType.STRING, (short)2);

  private static final Map<Class<? extends IScheme>, SchemeFactory> schemes = new HashMap<Class<? extends IScheme>, SchemeFactory>();
  static {
    schemes.put(StandardScheme.class, new TIsSentryAdminRequestStandardSchemeFactory());
    schemes.put(TupleScheme.class, new TIsSentryAdminRequestTupleSchemeFactory());
  }

  private int protocol_version; // required
  private String userName; // required

  /** The set of fields this struct contains, along with convenience methods for finding and manipulating them. */
  public enum _Fields implements org.apache.thrift.TFieldIdEnum {
    PROTOCOL_VERSION((short)1, "protocol_version"),
    USER_NAME((short)2, "userName");

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
        case 1: // PROTOCOL_VERSION
          return PROTOCOL_VERSION;
        case 2: // USER_NAME
          return USER_NAME;
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
  private static final int __PROTOCOL_VERSION_ISSET_ID = 0;
  private byte __isset_bitfield = 0;
  public static final Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> metaDataMap;
  static {
    Map<_Fields, org.apache.thrift.meta_data.FieldMetaData> tmpMap = new EnumMap<_Fields, org.apache.thrift.meta_data.FieldMetaData>(_Fields.class);
    tmpMap.put(_Fields.PROTOCOL_VERSION, new org.apache.thrift.meta_data.FieldMetaData("protocol_version", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.I32)));
    tmpMap.put(_Fields.USER_NAME, new org.apache.thrift.meta_data.FieldMetaData("userName", org.apache.thrift.TFieldRequirementType.REQUIRED, 
        new org.apache.thrift.meta_data.FieldValueMetaData(org.apache.thrift.protocol.TType.STRING)));
    metaDataMap = Collections.unmodifiableMap(tmpMap);
    org.apache.thrift.meta_data.FieldMetaData.addStructMetaDataMap(TIsSentryAdminRequest.class, metaDataMap);
  }

  public TIsSentryAdminRequest() {
    this.protocol_version = 2;

  }

  public TIsSentryAdminRequest(
    int protocol_version,
    String userName)
  {
    this();
    this.protocol_version = protocol_version;
    setProtocol_versionIsSet(true);
    this.userName = userName;
  }

  /**
   * Performs a deep copy on <i>other</i>.
   */
  public TIsSentryAdminRequest(TIsSentryAdminRequest other) {
    __isset_bitfield = other.__isset_bitfield;
    this.protocol_version = other.protocol_version;
    if (other.isSetUserName()) {
      this.userName = other.userName;
    }
  }

  public TIsSentryAdminRequest deepCopy() {
    return new TIsSentryAdminRequest(this);
  }

  @Override
  public void clear() {
    this.protocol_version = 2;

    this.userName = null;
  }

  public int getProtocol_version() {
    return this.protocol_version;
  }

  public void setProtocol_version(int protocol_version) {
    this.protocol_version = protocol_version;
    setProtocol_versionIsSet(true);
  }

  public void unsetProtocol_version() {
    __isset_bitfield = EncodingUtils.clearBit(__isset_bitfield, __PROTOCOL_VERSION_ISSET_ID);
  }

  /** Returns true if field protocol_version is set (has been assigned a value) and false otherwise */
  public boolean isSetProtocol_version() {
    return EncodingUtils.testBit(__isset_bitfield, __PROTOCOL_VERSION_ISSET_ID);
  }

  public void setProtocol_versionIsSet(boolean value) {
    __isset_bitfield = EncodingUtils.setBit(__isset_bitfield, __PROTOCOL_VERSION_ISSET_ID, value);
  }

  public String getUserName() {
    return this.userName;
  }

  public void setUserName(String userName) {
    this.userName = userName;
  }

  public void unsetUserName() {
    this.userName = null;
  }

  /** Returns true if field userName is set (has been assigned a value) and false otherwise */
  public boolean isSetUserName() {
    return this.userName != null;
  }

  public void setUserNameIsSet(boolean value) {
    if (!value) {
      this.userName = null;
    }
  }

  public void setFieldValue(_Fields field, Object value) {
    switch (field) {
    case PROTOCOL_VERSION:
      if (value == null) {
        unsetProtocol_version();
      } else {
        setProtocol_version((Integer)value);
      }
      break;

    case USER_NAME:
      if (value == null) {
        unsetUserName();
      } else {
        setUserName((String)value);
      }
      break;

    }
  }

  public Object getFieldValue(_Fields field) {
    switch (field) {
    case PROTOCOL_VERSION:
      return getProtocol_version();

    case USER_NAME:
      return getUserName();

    }
    throw new IllegalStateException();
  }

  /** Returns true if field corresponding to fieldID is set (has been assigned a value) and false otherwise */
  public boolean isSet(_Fields field) {
    if (field == null) {
      throw new IllegalArgumentException();
    }

    switch (field) {
    case PROTOCOL_VERSION:
      return isSetProtocol_version();
    case USER_NAME:
      return isSetUserName();
    }
    throw new IllegalStateException();
  }

  @Override
  public boolean equals(Object that) {
    if (that == null)
      return false;
    if (that instanceof TIsSentryAdminRequest)
      return this.equals((TIsSentryAdminRequest)that);
    return false;
  }

  public boolean equals(TIsSentryAdminRequest that) {
    if (that == null)
      return false;

    boolean this_present_protocol_version = true;
    boolean that_present_protocol_version = true;
    if (this_present_protocol_version || that_present_protocol_version) {
      if (!(this_present_protocol_version && that_present_protocol_version))
        return false;
      if (this.protocol_version != that.protocol_version)
        return false;
    }

    boolean this_present_userName = true && this.isSetUserName();
    boolean that_present_userName = true && that.isSetUserName();
    if (this_present_userName || that_present_userName) {
      if (!(this_present_userName && that_present_userName))
        return false;
      if (!this.userName.equals(that.userName))
        return false;
    }

    return true;
  }

  @Override
  public int hashCode() {
    List<Object> list = new ArrayList<Object>();

    boolean present_protocol_version = true;
    list.add(present_protocol_version);
    if (present_protocol_version)
      list.add(protocol_version);

    boolean present_userName = true && (isSetUserName());
    list.add(present_userName);
    if (present_userName)
      list.add(userName);

    return list.hashCode();
  }

  @Override
  public int compareTo(TIsSentryAdminRequest other) {
    if (!getClass().equals(other.getClass())) {
      return getClass().getName().compareTo(other.getClass().getName());
    }

    int lastComparison = 0;

    lastComparison = Boolean.valueOf(isSetProtocol_version()).compareTo(other.isSetProtocol_version());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetProtocol_version()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.protocol_version, other.protocol_version);
      if (lastComparison != 0) {
        return lastComparison;
      }
    }
    lastComparison = Boolean.valueOf(isSetUserName()).compareTo(other.isSetUserName());
    if (lastComparison != 0) {
      return lastComparison;
    }
    if (isSetUserName()) {
      lastComparison = org.apache.thrift.TBaseHelper.compareTo(this.userName, other.userName);
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
    StringBuilder sb = new StringBuilder("TIsSentryAdminRequest(");
    boolean first = true;

    sb.append("protocol_version:");
    sb.append(this.protocol_version);
    first = false;
    if (!first) sb.append(", ");
    sb.append("userName:");
    if (this.userName == null) {
      sb.append("null");
    } else {
      sb.append(this.userName);
    }
    first = false;
    sb.append(")");
    return sb.toString();
  }

  public void validate() throws org.apache.thrift.TException {
    // check for required fields
    if (!isSetProtocol_version()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'protocol_version' is unset! Struct:" + toString());
    }

    if (!isSetUserName()) {
      throw new org.apache.thrift.protocol.TProtocolException("Required field 'userName' is unset! Struct:" + toString());
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
      // it doesn't seem like you should have to do this, but java serialization is wacky, and doesn't call the default constructor.
      __isset_bitfield = 0;
      read(new org.apache.thrift.protocol.TCompactProtocol(new org.apache.thrift.transport.TIOStreamTransport(in)));
    } catch (org.apache.thrift.TException te) {
      throw new java.io.IOException(te);
    }
  }

  private static class TIsSentryAdminRequestStandardSchemeFactory implements SchemeFactory {
    public TIsSentryAdminRequestStandardScheme getScheme() {
      return new TIsSentryAdminRequestStandardScheme();
    }
  }

  private static class TIsSentryAdminRequestStandardScheme extends StandardScheme<TIsSentryAdminRequest> {

    public void read(org.apache.thrift.protocol.TProtocol iprot, TIsSentryAdminRequest struct) throws org.apache.thrift.TException {
      org.apache.thrift.protocol.TField schemeField;
      iprot.readStructBegin();
      while (true)
      {
        schemeField = iprot.readFieldBegin();
        if (schemeField.type == org.apache.thrift.protocol.TType.STOP) { 
          break;
        }
        switch (schemeField.id) {
          case 1: // PROTOCOL_VERSION
            if (schemeField.type == org.apache.thrift.protocol.TType.I32) {
              struct.protocol_version = iprot.readI32();
              struct.setProtocol_versionIsSet(true);
            } else { 
              org.apache.thrift.protocol.TProtocolUtil.skip(iprot, schemeField.type);
            }
            break;
          case 2: // USER_NAME
            if (schemeField.type == org.apache.thrift.protocol.TType.STRING) {
              struct.userName = iprot.readString();
              struct.setUserNameIsSet(true);
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

    public void write(org.apache.thrift.protocol.TProtocol oprot, TIsSentryAdminRequest struct) throws org.apache.thrift.TException {
      struct.validate();

      oprot.writeStructBegin(STRUCT_DESC);
      oprot.writeFieldBegin(PROTOCOL_VERSION_FIELD_DESC);
      oprot.writeI32(struct.protocol_version);
      oprot.writeFieldEnd();
      if (struct.userName != null) {
        oprot.writeFieldBegin(USER_NAME_FIELD_DESC);
        oprot.writeString(struct.userName);
        oprot.writeFieldEnd();
      }
      oprot.writeFieldStop();
      oprot.writeStructEnd();
    }

  }

  private static class TIsSentryAdminRequestTupleSchemeFactory implements SchemeFactory {
    public TIsSentryAdminRequestTupleScheme getScheme() {
      return new TIsSentryAdminRequestTupleScheme();
    }
  }

  private static class TIsSentryAdminRequestTupleScheme extends TupleScheme<TIsSentryAdminRequest> {

    @Override
    public void write(org.apache.thrift.protocol.TProtocol prot, TIsSentryAdminRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol oprot = (TTupleProtocol) prot;
      oprot.writeI32(struct.protocol_version);
      oprot.writeString(struct.userName);
    }

    @Override
    public void read(org.apache.thrift.protocol.TProtocol prot, TIsSentryAdminRequest struct) throws org.apache.thrift.TException {
      TTupleProtocol iprot = (TTupleProtocol) prot;
      struct.protocol_version = iprot.readI32();
      struct.setProtocol_versionIsSet(true);
      struct.userName = iprot.readString();
      struct.setUserNameIsSet(true);
    }
  }

}
