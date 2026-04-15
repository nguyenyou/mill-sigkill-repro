package generated

final case class Data110(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data110 = copy(name = name.toUpperCase)
  def scale(k: Double): Data110 = copy(value = value * k)
  def addTag(t: String): Data110 = copy(tags = t :: tags)
  def put(k: String, v: String): Data110 = copy(meta = meta.updated(k, v))
  def merge(other: Data110): Data110 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data110 {
  given Ordering[Data110] = Ordering.by(_.id)
  def empty: Data110 = Data110(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data110 =
    Data110(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data110] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
