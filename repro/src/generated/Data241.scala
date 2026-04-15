package generated

final case class Data241(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data241 = copy(name = name.toUpperCase)
  def scale(k: Double): Data241 = copy(value = value * k)
  def addTag(t: String): Data241 = copy(tags = t :: tags)
  def put(k: String, v: String): Data241 = copy(meta = meta.updated(k, v))
  def merge(other: Data241): Data241 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data241 {
  given Ordering[Data241] = Ordering.by(_.id)
  def empty: Data241 = Data241(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data241 =
    Data241(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data241] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
