package generated

final case class Data893(
    id: Int,
    name: String,
    value: Double,
    tags: List[String],
    meta: Map[String, String]
) {
  def upper: Data893 = copy(name = name.toUpperCase)
  def scale(k: Double): Data893 = copy(value = value * k)
  def addTag(t: String): Data893 = copy(tags = t :: tags)
  def put(k: String, v: String): Data893 = copy(meta = meta.updated(k, v))
  def merge(other: Data893): Data893 = copy(
      tags = (tags ++ other.tags).distinct,
      meta = meta ++ other.meta
  )
}

object Data893 {
  given Ordering[Data893] = Ordering.by(_.id)
  def empty: Data893 = Data893(0, "", 0.0, Nil, Map.empty)
  def of(id: Int, name: String): Data893 =
    Data893(id, name, 0.0, Nil, Map.empty)
  def list(n: Int): List[Data893] =
    (1 to n).iterator.map(i => of(i, s"item-$i")).toList
}
