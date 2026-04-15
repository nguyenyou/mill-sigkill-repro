package generated

final case class Data1126(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1126 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1126 = copy(value = value * k)
  def addTag(t: String): Data1126 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1126 = copy(meta = meta.updated(k, v))
  def merge(other: Data1126): Data1126 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1126 {
  given Ordering[Data1126] = Ordering.by(_.id)
  def empty: Data1126 = Data1126(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1126 =
    Data1126(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1126] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
