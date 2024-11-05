/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.DAO;

import br.com.DTO.EquipDTO;
import java.sql.*;
import javax.swing.JOptionPane;
import br.com.VIEWS.NovoEquip;

public class MaquinaDAO {
    Connection conexao = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    
    
    public void NovoEquip(EquipDTO objEquipDTO) {

        String sql = "insert into equipamento ( tipo_equipamento, status_equip, observacao,laboratorio_id,identificacao ) values (?, ?, ?,?,?)";

        conexao = ConexaoDAO.conector();

        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, objEquipDTO.getTipoEquipamento());
            pst.setString(2, objEquipDTO.getStatus());
            pst.setString(3, objEquipDTO.getObservacao());
            pst.setInt (4, objEquipDTO.getLaboratorioId());
            pst.setString(5, objEquipDTO.getIdentificacao());
            
            pst.execute();

         
            JOptionPane.showMessageDialog(null, "Maquina cadastrada com sucesso!");
            LimpaCampos();

            pst.close();

        } catch (Exception e) {
            if (e.getMessage().contains("'")) {
                
                JOptionPane.showMessageDialog(null, "Erro.");
                
            }
            JOptionPane.showMessageDialog(null, e);
        }

    }
        public void LimpaCampos() {
        NovoEquip.txtabspert.setText(null); 
        NovoEquip.txtiden.setText(null);
        NovoEquip.txtobs.setText(null);
    }
    
}
