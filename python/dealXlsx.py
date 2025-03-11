import openpyxl
import pandas

wb = openpyxl.load_workbook('销售时间20241101-20250116.xlsx')
ws = wb.active
print(ws['A1'].value)

columns = ws.columns
rows = ws.rows
print('1')

sheet = pandas.read_excel('销售时间20241101-20250116.xlsx', engine='openpyxl')
print('1')
rows = sheet.values
for row in rows:
    print(f'{row[0]}--------{row[9]}')