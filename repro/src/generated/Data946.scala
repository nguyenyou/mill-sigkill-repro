package generated

final case class Data946(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data946 = copy(name = name.toUpperCase)
  def scale(k: Double): Data946 = copy(value = value * k)
  def addTag(t: String): Data946 = copy(tags = t :: tags)
  def put(k: String, v: String): Data946 = copy(meta = meta.updated(k, v))
  def merge(other: Data946): Data946 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data946 {
  given Ordering[Data946] = Ordering.by(_.id)
  def empty: Data946 = Data946(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data946 =
    Data946(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data946] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
