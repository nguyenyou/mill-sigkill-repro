package generated

final case class Data1107(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1107 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1107 = copy(value = value * k)
  def addTag(t: String): Data1107 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1107 = copy(meta = meta.updated(k, v))
  def merge(other: Data1107): Data1107 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1107 {
  given Ordering[Data1107] = Ordering.by(_.id)
  def empty: Data1107 = Data1107(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1107 =
    Data1107(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1107] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
