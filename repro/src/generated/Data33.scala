package generated

final case class Data33(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data33 = copy(name = name.toUpperCase)
  def scale(k: Double): Data33 = copy(value = value * k)
  def addTag(t: String): Data33 = copy(tags = t :: tags)
  def put(k: String, v: String): Data33 = copy(meta = meta.updated(k, v))
  def merge(other: Data33): Data33 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data33 {
  given Ordering[Data33] = Ordering.by(_.id)
  def empty: Data33 = Data33(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data33 =
    Data33(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data33] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
