unit Unit1;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls;

type
  TForm1 = class(TForm)
    GroupBox1: TGroupBox;
    GroupBox2: TGroupBox;
    eA: TEdit;
    Label1: TLabel;
    Label2: TLabel;
    Label3: TLabel;
    eB: TEdit;
    eC: TEdit;
    Button1: TButton;
    lblDiscriminant: TLabel;
    btnClose: TButton;
    lblX1: TLabel;
    lblX2: TLabel;
    procedure Button1Click(Sender: TObject);
    procedure btnCloseClick(Sender: TObject);
    procedure FormShow(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;             

var
  Form1: TForm1;

implementation

{$R *.dfm}

procedure TForm1.Button1Click(Sender: TObject);
var
  // ���������� ���������� ��� ������� ��������� ������
  a, b, c: Double;
  // ���������� ���������� ��� ���������� ��������
  x1, x2, D: Double;
begin
  // ������������� ���������� ���������� �������
  a := StrToFloat(eA.Text);
  b := StrToFloat(eB.Text);
  c := StrToFloat(eC.Text);

  // ��������� �������������
  D := sqr(b) - 4 * a * c;

  // ����� ����������, �� ��������� �������������
  if D < 0 then
  begin
    // ����� �������������.
    lblDiscriminant.Caption := '������������ = ' + FloatToStr(D)
        + '. ������ ���!';
    // ������� ������ x1 � x2
    lblX1.Caption := '';
    lblX2.Caption := '';

  end;

  if D = 0 then
  begin
    // ����� �������������
    lblDiscriminant.Caption := '������������ = ' + FloatToStr(D)
        + '. ���� ������ ���������!';
    x1 := (-b + sqrt(D))/(2 * a);
    // ����� ������� ����� ���������.
    lblX1.Caption := 'X1 = ' + FloatToStr(x1);
    // ������� ������ ������� ����� ���������.
    lblX2.Caption := '';
  end;

  if D > 0 then
  begin
    // ����� �������������
    lblDiscriminant.Caption := '������������ = ' + FloatToStr(D)
        + '. ��������� ����� ��� �����!';
    // ������� ������ ���������.
    x1 := (-b + sqrt(D))/(2 * a);
    x2 := (-b - sqrt(D))/(2 * a);
    // ����� ������� ����� ���������.
    lblX1.Caption := 'X1 = ' + FloatToStr(x1);
    // ����� ������� ����� ���������.
    lblX2.Caption := 'X2 = ' + FloatToStr(x2);
  end;
end;

procedure TForm1.btnCloseClick(Sender: TObject);
begin
  Close;
end;

procedure TForm1.FormShow(Sender: TObject);
begin
  // ������� ����������� lable ������ ������ ���������
  lblX1.Caption := '';
  lblX2.Caption := '';
end;

end.