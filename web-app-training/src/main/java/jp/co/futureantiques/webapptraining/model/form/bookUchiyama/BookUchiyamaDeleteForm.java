package jp.co.futureantiques.webapptraining.model.form.bookUchiyama;

import java.util.ArrayList;

import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class BookUchiyamaDeleteForm {
@Size(min=1, message="common.text.error.require.check")
private ArrayList<Long> deleteIds;
}
