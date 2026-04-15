package generated

final case class Data849(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data849 = copy(name = name.toUpperCase)
  def scale(k: Double): Data849 = copy(value = value * k)
  def addTag(t: String): Data849 = copy(tags = t :: tags)
  def put(k: String, v: String): Data849 = copy(meta = meta.updated(k, v))
  def merge(other: Data849): Data849 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data849 {
  given Ordering[Data849] = Ordering.by(_.id)
  def empty: Data849 = Data849(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data849 =
    Data849(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data849] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
