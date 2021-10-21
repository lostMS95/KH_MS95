package home.beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CoinDao {
	public static final String USERNAME = "kh";
	public static final String PASSWORD = "kh";
	
	//coin 상품 전체 목록 조회
	public List<CoinDto> list() throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);
		
		String sql = "select * from coin order by coin_amount asc" ;
		PreparedStatement ps=con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		//copy
		List<CoinDto>coinList = new ArrayList<CoinDto>(); 
		while(rs.next()) {
			CoinDto coinDto = new CoinDto();
			
			coinDto.setCoinNo(rs.getInt("coin_no"));
			coinDto.setCoinName(rs.getString("coin_name"));
			coinDto.setCoinAmount(rs.getInt("coin_amount"));
			
			coinList.add(coinDto);
		}
		con.close();
		return coinList;
	}

	public CoinDto get(int coinNo) throws Exception {
		Connection con = JdbcUtils.connect(USERNAME, PASSWORD);
		
		String sql = "select * from coin where coin_no = ?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setInt(1, coinNo);
		ResultSet rs = ps.executeQuery();
		
		CoinDto coinDto;
		if(rs.next()) {
			coinDto = new CoinDto();
			
			coinDto.setCoinNo(rs.getInt("coin_no"));
			coinDto.setCoinName(rs.getString("coin_name"));
			coinDto.setCoinAmount(rs.getInt("coin_amount"));
		}
		else {
			coinDto = null;
		}
		con.close();
		return coinDto;
	}
}	
