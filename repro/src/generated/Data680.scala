package generated

final case class Data680(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data680 = copy(name = name.toUpperCase)
  def scale(k: Double): Data680 = copy(value = value * k)
  def addTag(t: String): Data680 = copy(tags = t :: tags)
  def put(k: String, v: String): Data680 = copy(meta = meta.updated(k, v))
  def merge(other: Data680): Data680 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data680 {
  given Ordering[Data680] = Ordering.by(_.id)
  def empty: Data680 = Data680(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data680 =
    Data680(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data680] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
