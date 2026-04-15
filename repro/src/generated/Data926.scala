package generated

final case class Data926(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data926 = copy(name = name.toUpperCase)
  def scale(k: Double): Data926 = copy(value = value * k)
  def addTag(t: String): Data926 = copy(tags = t :: tags)
  def put(k: String, v: String): Data926 = copy(meta = meta.updated(k, v))
  def merge(other: Data926): Data926 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data926 {
  given Ordering[Data926] = Ordering.by(_.id)
  def empty: Data926 = Data926(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data926 =
    Data926(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data926] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
