<%@ taglib prefix="s" uri="/struts-tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		
		<title>野球打撃成績</title>
			
	</head>
	<body>
<!-- スコアボード -->
		<table><tr valign="top"><th bgcolor="#90ee90" height="25"> 
			<table border="1" style="font-size:27px;">
			
				<caption align="top">スコアボード</caption>
				
				<tr align="center">
					<th width="150">チーム名</th>
					<th width="40">1</th>
					<th width="40">2</th>
					<th width="40">3</th>
					<th width="40">4</th>
					<th width="40">5</th>
					<th width="40">6</th>
					<th width="40">7</th>
					<th width="40">8</th>
					<th width="40">9</th>
					<th width="40">10</th>
					<th width="40">11</th>
					<th width="40">12</th>
					<th width="40">R</th>
					<th width="40">H</th>
					<th width="40">E</th>
				</tr>
				
				<tr align="center">
					<th>Aチーム</th>
					<td><s:property value="teamA.scores[0]"/></td><!-- 1 -->
					<td><s:property value="teamA.scores[1]"/></td><!-- 2 -->
					<td><s:property value="teamA.scores[2]"/></td><!-- 3 -->
					<td><s:property value="teamA.scores[3]"/></td><!-- 4 -->
					<td><s:property value="teamA.scores[4]"/></td><!-- 5 -->
					<td><s:property value="teamA.scores[5]"/></td><!-- 6 -->
					<td><s:property value="teamA.scores[6]"/></td><!-- 7 -->
					<td><s:property value="teamA.scores[7]"/></td><!-- 8 -->
					<td><s:property value="teamA.scores[8]"/></td><!-- 9 -->
					<td><s:property value="teamA.scores[9]"/></td><!-- 10 -->
					<td><s:property value="teamA.scores[10]"/></td><!-- 11 -->
					<td><s:property value="teamA.scores[11]"/></td><!-- 12 -->
					<td><s:property value="teamA.run"/></td><!-- R -->
					<td><s:property value="teamA.hit"/></td><!-- H -->
					<td><s:property value="teamB.error"/></td><!-- E -->
				</tr>
				
				<tr align="center">
					<th>Bチーム</th>
					<td><s:property value="teamB.scores[0]"/></td><!-- 1 -->
					<td><s:property value="teamB.scores[1]"/></td><!-- 2 -->
					<td><s:property value="teamB.scores[2]"/></td><!-- 3 -->
					<td><s:property value="teamB.scores[3]"/></td><!-- 4 -->
					<td><s:property value="teamB.scores[4]"/></td><!-- 5 -->
					<td><s:property value="teamB.scores[5]"/></td><!-- 6 -->
					<td><s:property value="teamB.scores[6]"/></td><!-- 7 -->
					<td><s:property value="teamB.scores[7]"/></td><!-- 8 -->
					<td><s:property value="teamB.scores[8]"/></td><!-- 9 -->
					<td><s:property value="teamB.scores[9]"/></td><!-- 10 -->
					<td><s:property value="teamB.scores[10]"/></td><!-- 11 -->
					<td><s:property value="teamB.scores[11]"/></td><!-- 12 -->
					<td><s:property value="teamB.run"/></td><!-- R -->
					<td><s:property value="teamB.hit"/></td><!-- H -->
					<td><s:property value="teamA.error"/></td><!-- E -->
				</tr>
			</table>
		</th>
<!-- スコアボードここまで -->
		
		<td>　　　　　　
		</td>
		
<!-- 打撃内容表 -->
		<td valign="top" rowspan="4">
			
			<table border="1" style="font-size:20px;">
			<caption align="top">打撃内容</caption>
				<tr>
					<th>打者</th>
					<th colspan="2">内容</th>
					<th>打点</th>
				</tr>
				<s:iterator value="resultList">
					<tr>
						<td width="150" align="center"><s:property value="batterList"/><br></td>
						<td width="40" align="center"><s:property value="content1"/></td>
						<td width="75" align="center"><s:property value="content2"/></td>
						<td width="40" align="center"><s:property value="rbi"/></td>
					</tr>
				</s:iterator>
				
			</table>
		</td>
		</tr>
<!-- 打撃内容表ここまで -->

		<tr valign="top">
		
<!-- 入力セル -->
		<td style="font-size:30px;">
		<br>
		<s:form>
		<s:submit method="playBall" value="試合開始" style="font-size:30px"/>
		<br>
		<b>現在</b>　<s:property value="inningName"/><s:property value="outCount"/>アウト<br>
		" <s:property value="batter"/> " です。<br><br>
						
	　			<s:select name="content1" value="content1" style="font-size:20px"
					list="#{'　':'内容1','投':'投','捕':'捕','一':'一','二':'二','三':'三',
					'遊':'遊','左':'左','中':'中','右':'右','左前':'左前','左越':'左越',
					'中前':'中前','中越':'中越','右前':'右前','右越':'右越'}"/>
					
				<s:select name="content2" value="content2" style="font-size:20px"
					list="#{'　':'内容2','ゴロ':'ゴロ','直':'直','飛':'飛','失策':'失策',
					'邪直':'邪直','邪飛':'邪飛','併殺打':'併殺打','見三振':'見三振',
					'空三振':'空三振','四球':'四球','死球':'死球','犠打':'犠打',
					'犠飛':'犠飛','スクイズ':'スクイズ','安打':'安打','二塁打':'二塁打',
					'三塁打':'三塁打','本塁打':'本塁打'}"/>
		　　　		
			打点	<s:select name="rbi" value="rbi" style="font-size:20px"
					list="#{'0':'0','1':'1','2':'2','3':'3','4':'4'}"/>
				
				
			　	<s:submit method="input" value="入力" style="font-size:30px"/>
			　	<s:submit method="change" value="チェンジ" style="font-size:30px"/><br><br>
				<s:submit method="outSum" value="アウト" style="font-size:30px"/>
				<s:submit method="scoreSum" value="得点(打点無し)" style="font-size:30px"/>
				<s:submit method="errorSum" value="エラー" style="font-size:30px"/>
	　	　　　　　	<s:submit method="gameSet" value="試合終了" style="font-size:30px"/>
			</s:form>
			
			
		</td>
		</tr>
<!-- 入力セル ここまで-->
<!-- 調整用行 -->
		<tr>
		<td>
		</td>
		</tr>
		
		</table>

			



</body>
</html>