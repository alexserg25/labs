unit Unit2;

interface

uses
  Windows, Messages, SysUtils, Variants, Classes, Graphics, Controls, Forms,
  Dialogs, StdCtrls;

type
  TForm1 = class(TForm)
    Button1: TButton;
    Button2: TButton;
    eX1: TEdit;
    Label1: TLabel;
    eY1: TEdit;
    eX2: TEdit;
    eY2: TEdit;
    Label2: TLabel;
    Label3: TLabel;
    Label5: TLabel;
    Label4: TLabel;
    labelResult: TLabel;
    procedure Button2Click(Sender: TObject);
    procedure Button1Click(Sender: TObject);
  private
    { Private declarations }
  public
    { Public declarations }
  end;

var
  Form1: TForm1;

implementation

{$R *.dfm}

// ����� ��������� ������� ������� ������ Button2
procedure TForm1.Button2Click(Sender: TObject);
begin
  Close;
end;

// ����� ��������� ������� ������� ������ Button1
procedure TForm1.Button1Click(Sender: TObject);
var
  // ���������� ����� ������
  ab: Double;
  // ���������� ��������� �����
  x1, x2, y1, y2: Integer;
begin
  // ���������� ��������� ���������� �� ��������� �����
  x1 := StrToInt(eX1.Text);
  x2 := StrToInt(eX2.Text);
  y1 := StrToInt(eY1.Text);
  y2 := StrToInt(eY2.Text);

  // ��������� �� ������� ������� �������
  ab := sqrt(sqr(x2 - x1) + sqr(y2 - y1));

  // ����� ����������
  labelResult.Caption := '���������� �����: ' + FloatToStr(ab);
end;

end.
