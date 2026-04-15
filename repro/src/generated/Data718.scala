package generated

final case class Data718(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data718 = copy(name = name.toUpperCase)
  def scale(k: Double): Data718 = copy(value = value * k)
  def addTag(t: String): Data718 = copy(tags = t :: tags)
  def put(k: String, v: String): Data718 = copy(meta = meta.updated(k, v))
  def merge(other: Data718): Data718 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data718 {
  given Ordering[Data718] = Ordering.by(_.id)
  def empty: Data718 = Data718(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data718 =
    Data718(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data718] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
