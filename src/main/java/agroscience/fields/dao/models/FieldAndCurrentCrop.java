package agroscience.fields.dao.models;

import agroscience.fields.dao.entities.Crop;
import agroscience.fields.dao.entities.CropRotation;
import agroscience.fields.dao.entities.Field;


public interface FieldAndCurrentCrop {
    Field getField();
    CropRotation getCropRotation();
}
