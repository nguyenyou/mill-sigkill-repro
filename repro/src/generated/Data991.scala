package generated

final case class Data991(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data991 = copy(name = name.toUpperCase)
  def scale(k: Double): Data991 = copy(value = value * k)
  def addTag(t: String): Data991 = copy(tags = t :: tags)
  def put(k: String, v: String): Data991 = copy(meta = meta.updated(k, v))
  def merge(other: Data991): Data991 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data991 {
  given Ordering[Data991] = Ordering.by(_.id)
  def empty: Data991 = Data991(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data991 =
    Data991(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data991] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
