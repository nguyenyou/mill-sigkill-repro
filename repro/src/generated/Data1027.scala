package generated

final case class Data1027(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1027 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1027 = copy(value = value * k)
  def addTag(t: String): Data1027 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1027 = copy(meta = meta.updated(k, v))
  def merge(other: Data1027): Data1027 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1027 {
  given Ordering[Data1027] = Ordering.by(_.id)
  def empty: Data1027 = Data1027(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1027 =
    Data1027(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1027] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
