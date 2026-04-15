package generated

final case class Data350(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data350 = copy(name = name.toUpperCase)
  def scale(k: Double): Data350 = copy(value = value * k)
  def addTag(t: String): Data350 = copy(tags = t :: tags)
  def put(k: String, v: String): Data350 = copy(meta = meta.updated(k, v))
  def merge(other: Data350): Data350 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data350 {
  given Ordering[Data350] = Ordering.by(_.id)
  def empty: Data350 = Data350(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data350 =
    Data350(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data350] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
