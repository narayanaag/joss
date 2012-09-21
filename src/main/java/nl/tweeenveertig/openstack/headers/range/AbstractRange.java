package nl.tweeenveertig.openstack.headers.range;

import nl.tweeenveertig.openstack.headers.Header;

/**
 * Offers the option to return not the entire object, but only a designated part. The various options are
 * <ul>
 *     <li>{@link ExcludeStartRange} - take the object starting from position x until the end</li>
 *     <li>{@link FirstPartRange} - take the first x bytes of the object, starting at position 0</li>
 *     <li>{@link MidPartRange} - take the object from offset for a certain length</li>
 *     <li>{@link LastPartRange} - take the last x bytes, starting at the end minus x until the end</li>
 * </ul>
 * Also see: http://docs.openstack.org/api/openstack-object-storage/1.0/content/retrieve-object.html
 */
public class AbstractRange extends Header {

    public String RANGE_HEADER_NAME = "Range";
    public String RANGE_HEADER_VALUE_PREFIX = "bytes=";

    private long offset;

    private long length;

    protected AbstractRange(long offset, long length) {
        this.offset = offset;
        this.length = length;
    }

    public String getHeaderValue() {
        return
            RANGE_HEADER_VALUE_PREFIX+
                (offset >= 0 ? Long.toString(offset) : "") +
                "-" +
                (length >= 0 ? Long.toString(length) : "");
    }

    public String getHeaderName() {
        return RANGE_HEADER_NAME;
    }
}
