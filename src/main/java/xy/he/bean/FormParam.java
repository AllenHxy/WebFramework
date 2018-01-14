package xy.he.bean;

/**
 * Created by hexiuyu on 2018/1/14.But Nobody cares
 */
public class FormParam {
    String fieldName; //参数名称
    Object value; //值

    public FormParam(String fieldName, Object value) {
        this.fieldName = fieldName;
        this.value = value;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }
}
