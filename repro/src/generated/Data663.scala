package generated

final case class Data663(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data663 = copy(name = name.toUpperCase)
  def scale(k: Double): Data663 = copy(value = value * k)
  def addTag(t: String): Data663 = copy(tags = t :: tags)
  def put(k: String, v: String): Data663 = copy(meta = meta.updated(k, v))
  def merge(other: Data663): Data663 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data663 {
  given Ordering[Data663] = Ordering.by(_.id)
  def empty: Data663 = Data663(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data663 =
    Data663(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data663] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
