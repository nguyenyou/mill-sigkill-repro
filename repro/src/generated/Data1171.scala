package generated

final case class Data1171(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data1171 = copy(name = name.toUpperCase)
  def scale(k: Double): Data1171 = copy(value = value * k)
  def addTag(t: String): Data1171 = copy(tags = t :: tags)
  def put(k: String, v: String): Data1171 = copy(meta = meta.updated(k, v))
  def merge(other: Data1171): Data1171 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data1171 {
  given Ordering[Data1171] = Ordering.by(_.id)
  def empty: Data1171 = Data1171(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data1171 =
    Data1171(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data1171] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
