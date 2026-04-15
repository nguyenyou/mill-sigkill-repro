package generated

final case class Data650(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data650 = copy(name = name.toUpperCase)
  def scale(k: Double): Data650 = copy(value = value * k)
  def addTag(t: String): Data650 = copy(tags = t :: tags)
  def put(k: String, v: String): Data650 = copy(meta = meta.updated(k, v))
  def merge(other: Data650): Data650 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data650 {
  given Ordering[Data650] = Ordering.by(_.id)
  def empty: Data650 = Data650(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data650 =
    Data650(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data650] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
