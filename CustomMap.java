package service;

public class CustomMap {

    public CustomMap() {
        super();
    }

    @Override
    public Object put(Object key, Object value) {
        if (value instanceof oracle.sql.CLOB) {
            return super.put(convertUnderscoreToCamelCase(String.valueOf(key)), clobToString((CLOB) value));
        } else if (value instanceof com.tmax.tibero.jdbc.TbClob) {
            return super.put(convertUnderscoreToCamelCase(String.valueOf(key)),
                    "" + tbClobToString((TbClob) value));
        } else if (value instanceof weblogic.jdbc.vendor.oracle.OracleThinClob) {
            return super.put(convertUnderscoreToCamelCase(String.valueOf(key)), clobToString((Clob) value));
        } else {
            return super.put(convertUnderscoreToCamelCase(String.valueOf(key)), value);
        }
    }

    private StringBuffer clobToString(CLOB clob) {
        StringBuffer result = new StringBuffer();
        try {
            Reader reader = clob.getCharacterStream();
            char[] buffer = new char[1024];
            int numChars = 0;
            while ((numChars = reader.read(buffer)) > 0) {
                result.append(buffer, 0, numChars);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private StringBuffer clobToString(Clob clob) {
        StringBuffer result = new StringBuffer();
        try {
            Reader reader = clob.getCharacterStream();
            char[] buffer = new char[1024];
            int numChars = 0;
            while ((numChars = reader.read(buffer)) > 0) {
                result.append(buffer, 0, numChars);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    private StringBuffer tbClobToString(TbClob clob) {
        StringBuffer result = new StringBuffer();
        try {
            Reader reader = clob.getCharacterStream();
            char[] buffer = new char[1024];
            int numChars = 0;
            while ((numChars = reader.read(buffer)) > 0) {
                result.append(buffer, 0, numChars);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    @Override
    public Object get(Object key) {
        return super.get(key);
    }

    public <T> T get(Object key, Class<T> requiredType) {
        Object result = null;
        try {
            if (requiredType == Integer.class) {
                try {
                    result = this.get(key) == null ? 0 : JavaUtil.toInt(String.valueOf(this.get(key)));
                } catch (Exception e) {
                    result = 0;
                }
            } else if (requiredType == Float.class) {
                try {
                    result = this.get(key) == null ? 0 : JavaUtil.toFloat(String.valueOf(this.get(key)));
                } catch (Exception e) {
                    result = 0;
                }
            } else if (requiredType == Double.class) {
                try {
                    result = this.get(key) == null ? 0 : JavaUtil.toDouble(String.valueOf(this.get(key)));
                } catch (Exception e) {
                    result = 0;
                }
            } else if (requiredType == String.class) {
                try {
                    result = this.get(key) == null ? "" : String.valueOf(this.get(key));
                } catch (Exception e) {
                    result = "";
                }
            } else if (requiredType == Boolean.class) {
                try {
                    result = JavaUtil.toBoolean(String.valueOf(this.get(key)));
                } catch (Exception e) {
                    result = false;
                }
            } else {
                result = this.get(key) == null ? null : this.get(key);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (T) result;
    }
}
