package generated

final case class Data883(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data883 = copy(name = name.toUpperCase)
  def scale(k: Double): Data883 = copy(value = value * k)
  def addTag(t: String): Data883 = copy(tags = t :: tags)
  def put(k: String, v: String): Data883 = copy(meta = meta.updated(k, v))
  def merge(other: Data883): Data883 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data883 {
  given Ordering[Data883] = Ordering.by(_.id)
  def empty: Data883 = Data883(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data883 =
    Data883(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data883] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
