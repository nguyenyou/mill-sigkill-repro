package generated

final case class Data862(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data862 = copy(name = name.toUpperCase)
  def scale(k: Double): Data862 = copy(value = value * k)
  def addTag(t: String): Data862 = copy(tags = t :: tags)
  def put(k: String, v: String): Data862 = copy(meta = meta.updated(k, v))
  def merge(other: Data862): Data862 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data862 {
  given Ordering[Data862] = Ordering.by(_.id)
  def empty: Data862 = Data862(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data862 =
    Data862(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data862] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
