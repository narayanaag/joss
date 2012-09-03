package nl.t42.openstack.command.core;

public enum CommandExceptionError {
    UNKNOWN,
    CONTAINER_ALREADY_EXISTS,
    CONTAINER_DOES_NOT_EXIST,
    CONTAINER_NOT_EMPTY,
    MD5_CHECKSUM,
    MISSING_CONTENT_LENGTH_OR_TYPE,
    UNAUTHORIZED
}
