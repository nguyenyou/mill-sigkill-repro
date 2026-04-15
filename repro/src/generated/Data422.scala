package generated

final case class Data422(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data422 = copy(name = name.toUpperCase)
  def scale(k: Double): Data422 = copy(value = value * k)
  def addTag(t: String): Data422 = copy(tags = t :: tags)
  def put(k: String, v: String): Data422 = copy(meta = meta.updated(k, v))
  def merge(other: Data422): Data422 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data422 {
  given Ordering[Data422] = Ordering.by(_.id)
  def empty: Data422 = Data422(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data422 =
    Data422(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data422] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
