package fgo.xiaox.archar.pojo.table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TableInfo {


    /**
     * Name : demo
     * Engine : InnoDB
     * Version : 10
     * Row_format : Dynamic
     * Rows : 10
     * Avg_row_length : 1638
     * Data_length : 16384
     * Max_data_length : 0
     * Index_length : 16384
     * Data_free : 0
     * Auto_increment : null
     * Create_time : 1610413696000
     * Update_time : null
     * Check_time : null
     * Collation : utf8mb4_general_ci
     * Checksum : null
     * Create_options :
     * Comment :
     */

    private String Name;
    private String Comment;

    private List<ColumnInfo> columnInfos;
}
