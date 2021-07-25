unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls;

type
  TForm1 = class(TForm)
    GroupBox1: TGroupBox;
    GroupBox2: TGroupBox;
    eAx: TEdit;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    eBx: TEdit;
    eCx: TEdit;
    lenAD: TLabel;
    Button1: TButton;
    Label4: TLabel;
    eDx: TEdit;
    Label5: TLabel;
    Label6: TLabel;
    Label7: TLabel;
    eAy: TEdit;
    eBy: TEdit;
    eCy: TEdit;
    eDy: TEdit;
    Label8: TLabel;
    lenBD: TLabel;
    lenCD: TLabel;
    btnClose: TButton;
    minLen: TLabel;
    procedure Button1Click(Sender: TObject);
    procedure btnCloseClick(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

uses Math;

{$R *.dfm}

procedure TForm1.Button1Click(Sender: TObject);
var
  // ���������� ���������� ��� ������� ��������� ������
  Ax, Ay, Bx, By, Cx, Cy, Dx, Dy : Integer;
  // ���������� ���������� ��� ���������� ��������
  AD, BD, CD, minLength: Double;
begin
  // ������������� ���������� ���������� �������
  Ax := StrToInt(eAx.Text);
  Ay := StrToInt(eAy.Text);
  Bx := StrToInt(eBx.Text);
  By := StrToInt(eBy.Text);
  Cx := StrToInt(eCx.Text);
  Cy := StrToInt(eCy.Text);

  Dx := StrToInt(eDx.Text);
  Dy := StrToInt(eDy.Text);

  // ��������� ����������� ��������
  AD := sqrt(sqr(Dx - Ax) + sqr(Dy - Ay));
  BD := sqrt(sqr(Dx - Bx) + sqr(Dy - By));
  CD := sqrt(sqr(Dx - Cx) + sqr(Dy - Cy));

  // ����� �� ����� ����������� ����������
  lenAD.Caption := '���������� �� A �� D = ' + FloatToStr(abs(AD));
  lenBD.Caption := '���������� �� B �� D = ' + FloatToStr(abs(BD));
  lenCD.Caption := '���������� �� C �� D = ' + FloatToStr(abs(CD));

  // �������� �� ������
  AD := abs(AD);
  BD := abs(BD);
  CD := abs(CD);
  // ��������� ������������ ����������
  minLength := Min(Min(AD, BD), CD);
  
  // ����� ������������ ����������.
  minLen.Caption := '����������� ����������  = ' + FloatToStr(minLength);

end;

procedure TForm1.btnCloseClick(Sender: TObject);
begin
  Close;
end;

end.
